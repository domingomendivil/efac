package xg.caebusiness;


public class CAEBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CAEBusinessException(Throwable e) {
		super(e);
	}

	public CAEBusinessException(String string) {
		super(string);
	}

}
