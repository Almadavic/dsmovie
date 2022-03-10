package com.devsuperior.dsmovie.validations;

public class ErrorFormDto {

	private String campo;
	private String mensagemError;

	public ErrorFormDto() {

	}

	public ErrorFormDto(String campo, String mensagemError) {
		this.campo = campo;
		this.mensagemError = mensagemError;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagemError() {
		return mensagemError;
	}

	public void setMensagemError(String mensagemError) {
		this.mensagemError = mensagemError;
	}

}
