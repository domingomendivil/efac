package org.example.efactura_x;

import javax.jws.WebService;

import uy.gub.dgi.cfe.CFEDefTypeX;


@WebService(endpointInterface="org.example.efactura_x.EfacturaX")
public class WSEFactura implements EfacturaX {

	@Override
	public OutGenerarCFE generarCFE(CFEDefTypeX parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutGenerarCFEs generarCFEs(ListaCFEX parameters) {
		// TODO Auto-generated method stub
		return null;
	}


}
