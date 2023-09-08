package br.com.eyre.eyre.api;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.eyre.eyre.bases.CrudBaseAPI;
import br.com.eyre.eyre.entity.Extra;
import br.com.eyre.eyre.service.ExtraService;
import br.com.eyre.eyre.vo.ExtraVO;

public class ExtraAPI extends CrudBaseAPI<Long, Extra, ExtraVO, ExtraService> {

	@Autowired
	private ExtraService extraService;

	@Override
	protected ExtraService getService() {
		return extraService;
	}

}
