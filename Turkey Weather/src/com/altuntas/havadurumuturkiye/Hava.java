package com.altuntas.havadurumuturkiye;


public class Hava {

	public Bolge bolge;
	public AnlikHava anlikhava = new AnlikHava();
	public Sicaklik sicaklik = new Sicaklik();
	
	public class AnlikHava{
		
		private int weahterId;
		private String condition;
		private String description;
		
		public int getWeahterId() {
			return weahterId;
		}
		public void setWeahterId(int weahterId) {
			this.weahterId = weahterId;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
	
	public class Sicaklik{
		private float temp;
		
		public float getTemp() {
			return temp;
		}

		public void setTemp(float temp) {
			this.temp = temp;
		}		
	}

}
