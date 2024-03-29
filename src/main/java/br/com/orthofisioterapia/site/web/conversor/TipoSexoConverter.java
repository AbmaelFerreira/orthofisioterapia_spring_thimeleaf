package br.com.orthofisioterapia.site.web.conversor;

import br.com.orthofisioterapia.site.domain.TipoSexo;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Abmael on 05/02/2019.
 */
public class TipoSexoConverter implements Converter<String, TipoSexo> {

    @Override
    public TipoSexo convert(String value) {
        char tipo = value.charAt(0);
        return tipo == TipoSexo.FEMININO.getDesc() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;
    }
}
