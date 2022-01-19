public class conturiBanci{
    	private String nume,prenume,companie,capital,extrase_cont;
    	public conturiBanci(String numeB, String prenumeB,String capitalB,String companieB,String extraseContB) {
    		nume = numeB;
    		prenume = prenumeB;
    		capital = capitalB;
    		companie = companieB;
    		extrase_cont = extraseContB;
    	}
    	 public String getNumeB(){return nume;}
         public String getPrenumeB(){return prenume;}
         public String getCapitalB(){return capital;}
         public String getCompanieB(){return companie;}
         public String getExtraseContB(){return extrase_cont;}
         public String toString(){
             return nume + " "+ prenume + "" + capital+" " + companie + " " + extrase_cont;
         }
    }