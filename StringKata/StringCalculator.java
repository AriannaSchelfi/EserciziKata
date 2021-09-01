import java.io.*;
import java.util.ArrayList;

class StringCalculator{

	public int counter = 0;

	public int GetCalledCount(){
		return counter;
	}

	public int Add(String numbers) throws Exception{
		counter++;

		if (numbers.isEmpty()== true){
			return 0;
		}

		else{
			int sum=0;
			int indexFirstNumber=0;//indice prima cifra del numero
			ArrayList<String> negativeNumbers = new ArrayList<String>();

			//Controllo se c'è un altro delimitatore da supportare oltre la virgola e \n
			char delimitatore='\0';
			if(numbers.substring(0,2).equals("//")){
				delimitatore = numbers.charAt(2);
				indexFirstNumber=4;
			}

			for(int i=indexFirstNumber; i<numbers.length(); i++){
				if (numbers.charAt(i)==',' || numbers.charAt(i)=='\n' || numbers.charAt(i)==delimitatore){
					String numberToSum=numbers.substring(indexFirstNumber,i);

					//Verifico se è un numero negativo, se non lo è sommo
					if(numberToSum.indexOf("-")==-1){
						sum+=Integer.parseInt(numberToSum);
						indexFirstNumber= i+1;
					}
					//Se numero negativo aggiungo alla lista
					else{
						negativeNumbers.add(numberToSum);
						indexFirstNumber= i+1;
					}
				}
			}

			//ULTIMO NUMERO
			String numberToSum=numbers.substring(indexFirstNumber);
			if(numberToSum.indexOf("-")==-1){
				sum+=Integer.parseInt(numberToSum);
			}
			else{
				negativeNumbers.add(numberToSum);
			}

			//Ecezzione se numeri negativi altrimenti restituisco la somma
			if(!negativeNumbers.isEmpty()){
				throw new Exception("Numeri negativi non permessi, presenti: "+ negativeNumbers);
			}
			return sum;
		}

	}
}