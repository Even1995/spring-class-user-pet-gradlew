package br.com.fia.api.usuario_pettech.controller.exception;

public class ValidateMessage {
    private String campo;
    private String message;
    public ValidateMessage(String campo, String mensagem){}

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
