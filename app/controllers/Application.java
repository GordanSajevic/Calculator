package controllers;

import models.MathCal;
import play.*;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	static Form<MathCal> newExpression = new Form<MathCal>(MathCal.class);
	
	public static boolean checkExp(String expression) {
		for (int i=0; i<expression.length(); i++){
			if(((int)expression.charAt(i)<48 || (int)expression.charAt(i)>57)&&((int)expression.charAt(i)!=43 && (int)expression.charAt(i)!=45)){
				return false;
			}
		}
		return true;
		
	}
	
	public static Result index(){
		return ok(index.render(""));
	}
	
	public static Result output(){
		String expression;
		expression = newExpression.bindFromRequest().get().getExpression();
		if(checkExp(expression)==false){
			flash("error", Messages.get("Value is not mathematical expression!"));
			return ok(index.render(""));
		}else{
			MathCal mathCal = new MathCal(expression);
			int number = mathCal.getIntResult(expression);
			String words = mathCal.getStringResult(number);
			return ok(result.render(expression, number, words));
		}
	}

}
