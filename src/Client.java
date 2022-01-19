 public class Client{
        private String name,prenume,parola, email, companie;
        public Client(String nu,String pr, String p, String e, String c){
            name=nu;
            prenume = pr;
            parola = p;
            email=e;
            companie=c;
        }
		public String getNume(){return name;}
        public String getPrenume(){return prenume;}
        public String getParola(){return parola;}
        public String getEmail(){return email;}
        public String getCompanie(){return companie;}
        public String toString(){
            return name+" "+prenume + "" + parola+" "+email+" "+companie;
        }
        
    }   
    