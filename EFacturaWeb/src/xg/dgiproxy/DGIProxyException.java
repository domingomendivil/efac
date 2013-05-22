package xg.dgiproxy;

public class DGIProxyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DGIProxyException(Throwable e) {
		super(e);
	}
	
	public DGIProxyException(String msg){
		super(msg);
	}

}
