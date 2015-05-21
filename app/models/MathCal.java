package models;

public class MathCal {
	
	private String expression;
	
	private String[] singleNum = {" one"," two"," three"," four"," five"," six"," seven",
			" eight"," nine"," ten"," eleven"," twelve"," thirteen"," fourteen"," fifteen",
			" sixteen"," seventeen"," eighteen"," nineteen"};
	private static final String[] tens = {" ten"," twenty"," thirty"," forty"," fifty",
	    	" sixty"," seventy"," eighty"," ninety"
	  };

	public MathCal(){
		this.expression = "0";	
	}
	
	public MathCal(String expression){
		this.expression = expression;
	}
	
	public String getExpression() {
		return expression;
	}
	
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	
	/**
	 * Method returns int value based on string expression
	 * @param expression
	 * @return int
	 */

	public int getIntResult(String expression){
		int num = 0;
		try {
			if(expression.contains("+") || expression.contains("-")){
				for (int i=0; i<expression.length(); i++){
					if(expression.charAt(i)=='+'){
						num = Integer.parseInt(expression.substring(0, i)) + Integer.parseInt(expression.substring(i+1, expression.length()));
					}else if(expression.charAt(i)=='-'){
						num = Integer.parseInt(expression.substring(0, i)) - Integer.parseInt(expression.substring(i+1, expression.length()));
					}
				}
			}else{
				num = Integer.parseInt(expression);
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * Method returns string value of given number
	 * @param num
	 * @return string
	 */
	
	public String getStringResult(int num){
		if(num<20){
			return singleNum[num-1];
		}else if(num >= 20 && num < 100){
			if(num % 10==0){
				return tens[num/10-1];
			}else{
				return tens[num/10-1] + singleNum[num%10-1];
			}
		}else if(num >=100 && num<1000){
			if(num % 100 == 0){
				return singleNum[num/100-1] + " hundred";
			}else if(num % 10 == 0){
				return singleNum[num/100-1] + " hundred" + tens[(num/10)%10-1];
			}else{
				return singleNum[num/100-1] + " hundred" + tens[(num/10)%10-1] + singleNum[num%10-1];
			}
		}
		return "Error";
	}
	
	
}
