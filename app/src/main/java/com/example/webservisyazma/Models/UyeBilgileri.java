package com.example.webservisyazma.Models;

public class UyeBilgileri{
	private String uyeokul;
	private String uyemailadres;
	private String uyeismi;
	private String uyeyasi;
	private String uyeresim;

	public void setUyeokul(String uyeokul){
		this.uyeokul = uyeokul;
	}

	public String getUyeokul(){
		return uyeokul;
	}

	public void setUyemailadres(String uyemailadres){
		this.uyemailadres = uyemailadres;
	}

	public String getUyemailadres(){
		return uyemailadres;
	}

	public void setUyeismi(String uyeismi){
		this.uyeismi = uyeismi;
	}

	public String getUyeismi(){
		return uyeismi;
	}

	public void setUyeyasi(String uyeyasi){
		this.uyeyasi = uyeyasi;
	}

	public String getUyeyasi(){
		return uyeyasi;
	}

	public void setUyeresim(String uyeresim){
		this.uyeresim = uyeresim;
	}

	public String getUyeresim(){
		return uyeresim;
	}

	@Override
 	public String toString(){
		return 
			"UyeBilgileri{" + 
			"uyeokul = '" + uyeokul + '\'' + 
			",uyemailadres = '" + uyemailadres + '\'' + 
			",uyeismi = '" + uyeismi + '\'' + 
			",uyeyasi = '" + uyeyasi + '\'' + 
			",uyeresim = '" + uyeresim + '\'' + 
			"}";
		}
}
