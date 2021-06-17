package testcases.CWE285_Improper_Authorization;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE285_Improper_Authorization__LDAP_Authenticate_01 extends AbstractTestCaseServlet {
	
	private static String userId = "test";
	private static String passwd = "pass";
	private static String ldapDomain = "test.evenstar.co.kr";
	private static String ldapPathFormat = "LDAP://%s/";

	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String path = String.format(ldapPathFormat, ldapDomain);
		String filterString = "(cn=mrtint)";

		DirContext context = null;

		Hashtable<String, String> properties = new Hashtable<String, String>();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		properties.put(Context.PROVIDER_URL, path);
		
		// FLAW
		properties.put(Context.SECURITY_AUTHENTICATION, "none");
		properties.put(Context.SECURITY_PRINCIPAL, userId);
		properties.put(Context.SECURITY_CREDENTIALS, passwd);

		try {
			context = new InitialDirContext(properties);
			SearchControls searcher = new SearchControls();

			searcher.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration<SearchResult> results = context.search(
					"OU=customer,DC=test,DC=evenstar,DC=co.kr", filterString, searcher);
			while (results.hasMore()) {
				SearchResult result = results.next();
				Attributes attrs = result.getAttributes();
				System.out.println(attrs.get("displayName"));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String path = String.format(ldapPathFormat, ldapDomain);
		String filterString = "(cn=mrtint)";

		DirContext context = null;

		Hashtable<String, String> properties = new Hashtable<String, String>();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		properties.put(Context.PROVIDER_URL, path);

		// FIX
		properties.put(Context.SECURITY_AUTHENTICATION, "simple");
		properties.put(Context.SECURITY_PRINCIPAL, userId);
		properties.put(Context.SECURITY_CREDENTIALS, passwd);

		try {
			context = new InitialDirContext(properties);
			SearchControls searcher = new SearchControls();

			searcher.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration<SearchResult> results = context.search(
					"OU=customer,DC=test,DC=evenstar,DC=co.kr", filterString, searcher);
			while (results.hasMore()) {
				SearchResult result = results.next();
				Attributes attrs = result.getAttributes();
				System.out.println(attrs.get("displayName"));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
