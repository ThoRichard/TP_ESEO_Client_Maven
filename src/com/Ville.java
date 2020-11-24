package com;

public class Ville {

	private String codeCommune; 
	private String nomCommune; 
	private String codePostal;
	private String libelleAcheminement; 
	private String ligne;
	private float latitude; 
	private float longitude; 
	
	public Ville() {

	}

	public Ville(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne,
			float latitude, float longitude) {
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne = ligne;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the codeCommune
	 */
	public String getCodeCommune() {
		return codeCommune;
	}
	/**
	 * @param codeCommune the codeCommune to set
	 */
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	/**
	 * @return the nomCommune
	 */
	public String getNomCommune() {
		return nomCommune;
	}
	/**
	 * @param nomCommune the nomCommune to set
	 */
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the libelleAcheminement
	 */
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}
	/**
	 * @param libelleAcheminement the libelleAcheminement to set
	 */
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}
	/**
	 * @return the ligne
	 */
	public String getLigne() {
		return ligne;
	}
	/**
	 * @param ligne the ligne to set
	 */
	public void setLigne(String ligne) {
		this.ligne = ligne;
	} 
}
