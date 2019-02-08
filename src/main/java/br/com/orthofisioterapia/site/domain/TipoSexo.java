package br.com.orthofisioterapia.site.domain;

/**
 * Created by Abmael on 05/02/2019.
 */
public enum TipoSexo {

    FEMININO('F'), MASCULINO('M');

    private char desc;

    TipoSexo(char desc) {
        this.desc = desc;
    }

    public char getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
