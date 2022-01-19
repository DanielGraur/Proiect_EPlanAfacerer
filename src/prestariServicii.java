public class prestariServicii{
    	private String nume,prenume,companie,domeniu_activare,servicii;
    	public prestariServicii(String numePS, String prenumePS,String companiePS,String domeniuAcPS,String serviciiPS) {
    		nume = numePS;
    		prenume = prenumePS;
    		companie = companiePS;
    		domeniu_activare = domeniuAcPS;
    		servicii = serviciiPS;
    	}
    	 public String getNumePS(){return nume;}
         public String getPrenumePS(){return prenume;}
         public String getCompaniePS(){return companie;}
         public String getDomeniuActivarePS(){return domeniu_activare;}
         public String getServiciiPS(){return servicii;}
         public String toString(){
             return nume + " "+ prenume + "" + companie+" " + domeniu_activare + " " + servicii;
         }
    }