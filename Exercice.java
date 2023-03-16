package exercices.jeudi16;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public abstract class Exercice {

    private static final String ValideParamsO = "([{<";
    private static final String ValideParamsC = ")[{>";
    public static boolean CheckValidParenth(String value){
        var verfied = new Stack<>();

        for (int i = 0; i < value.length(); i++) {
            if (ValideParamsO.indexOf(value.charAt(i)) != -1) {
                verfied.push(value.charAt(i));
            } else if (ValideParamsC.indexOf(value.charAt(i)) != -1) {
                if (verfied.empty()) {
                    return false;
                }
                if (ValideParamsO.indexOf((char) verfied.peek()) == ValideParamsC.indexOf(value.charAt(i))) {
                    verfied.pop();
                }
            }
        }
        return verfied.empty();
    }

    private static String Reverse(String value){
        String ret = "";
        for (int i = value.length()-1; i >= 0 ; i--) {
            ret += value.charAt(i);
        }
        return ret;
    }

    public static String ReverseList(String value){
        String ret = "";
        Stack<String> tmp = new Stack<>();
        for (int i = 0; i < value.length(); i++) {
            tmp.push(value.substring(i,i+1));
        }
        while (!tmp.empty()) {
            ret += tmp.pop();
        }
        return ret;
    }

    public static String FindUnique(String value){
        String ret =  "";
        HashMap<String, String> listed = new HashMap<String, String>();
        for (int i = 0; i < value.length(); i++) {
            if(listed.containsKey(value.substring(i,i+1))){
                listed.put(value.substring(i,i+1),"other");
            }else {
                listed.put(value.substring(i,i+1),"unique");
            }
        }

        for (int i = 0; i < value.length(); i++) {
            if (listed.get( value.substring(i,i+1) )== "unique"){
                ret+= value.substring(i,i+1) ;
            }
        }
        System.out.println(listed);

        return ret;
    }

    public static String FindPoli(String value){
        String ret =  "";
        HashMap<String, String> listed = new HashMap<String, String>();
        for (int i = 0; i < value.length(); i++) {
            if(listed.containsKey(value.substring(i,i+1))){
                listed.put(value.substring(i,i+1),"other");
            }else {
                listed.put(value.substring(i,i+1),"unique");
            }
        }

        for (int i = 0; i < value.length(); i++) {
            if (listed.get( value.substring(i,i+1) )== "other" ){
                ret+= value.substring(i,i+1) ;
                listed.put(value.substring(i,i+1),"");
            }
        }
        System.out.println(listed);

        return ret;
    }

}
