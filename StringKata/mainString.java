public class mainString {

   public static void main(String[] args) throws Exception{

    	System.out.println("\n---------------ESERCIZIO STRINGHE-----------------\n");

    	System.out.println("\n------PRIMO TEST-------\n"); //chiamo una sola volta la funzione Add
    	StringCalculator calculator1 = new StringCalculator();
    	String[] test1 ={"10,31,4",""};				
    	int[] aspectedResults1 ={45,0};

    	eseguiTest(calculator1,test1,aspectedResults1);
    	System.out.printf("\n\nIl metodo Add è stato chiamato %d volte\n", calculator1.GetCalledCount());

    	System.out.println("\n------SECONDO TEST-------\n"); //chiamo tante volte la funzione Add
    	StringCalculator calculator2 = new StringCalculator();
    	String[] test2 ={"1,2,3", "31,42,53", "5,34,55","23,4555,653,21", 
    					"56\n3,5,454", "546\n34\n4,355\n5", 
    					"//;\n23;45,34\n546", "//'\n34'45,543\n2'34",
    					"//)\n43)23,32,-45\n34", "//;\n324,-64;-78\n45,-3"};				
    	int[] aspectedResults2 ={6, 126,94, 5252, 518,944,648, 658, -1,-1};

    	eseguiTest(calculator2,test2,aspectedResults2);
    	System.out.printf("\n\nIl metodo Add è stato chiamato %d volte\n", calculator2.GetCalledCount());


    	System.out.println("\n------TERZO TEST-------\n"); //non chiamo mai la funzione Add
    	StringCalculator calculator3 = new StringCalculator();
    	String[] test3 ={};				
    	int[] aspectedResults3 ={};

    	eseguiTest(calculator3,test3,aspectedResults3);
    	System.out.printf("\n\nIl metodo Add è stato chiamato %d volte\n", calculator3.GetCalledCount());

    	 	
   }

   public static void eseguiTest(StringCalculator calculator, String[] test, int[] aspectedResults){
   		for (int i=0; i<test.length; i++){
    		try{
	    		int somma = calculator.Add(test[i]);
	    		if (somma== aspectedResults[i]){
	    			System.out.printf("Input: %s  ---->  La somma calcolata è: %d ed è corretta! \n",test[i].replace("\n","\\n"), somma);
	    		}
	    		else{
	    			System.out.printf("Input: %s  ---->  La somma calcolata è: %d ed è sbagliata! \n",test[i].replace("\n","\\n"), somma);
	    			System.out.println("SOMMA SBAGLIATA!");
	    			break;
	    		}
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
    	}
   }

}