package testcases.CWE476_NULL_Pointer_Dereference;



public class _CWE476_NULL_Pointer_Dereference__int_array_data_is_not_null_0101_good2 
{


    public void good() throws Throwable
    {

        goodB2G();
    }

    
    
    private void goodB2G() throws Throwable
    {
        int [] data;

        /* POTENTIAL FLAW: string is null */
        data = null;

        /* FIX: validate that data is non-null */
        if( data != null )
        {
            System.out.println("" + data.length);
        }
        else
        {
            System.out.println("data is null");
        }

    }

  
  
}

