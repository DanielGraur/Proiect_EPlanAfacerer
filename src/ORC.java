 public class ORC{
    	private String nume,prenume,companie,asociati_companie,capital;
    	public ORC(String numeO, String prenumeO,String companieO,String asociati_companieO,String capitalO) {
    		nume = numeO;
    		prenume = prenumeO;
    		companie = companieO;
    		asociati_companie = asociati_companieO;
    		capital = capitalO;
    	}
    	 public String getNumeORC(){return nume;}
         public String getPrenumeORC(){return prenume;}
         public String getCompanieORC(){return companie;}
         public String getAsociatiORC(){return asociati_companie;}
         public String getCapitalORC(){return capital;}
         public String toString(){
             return nume+" "+prenume + "" + companie+" "+asociati_companie+" "+capital;
         }
    }