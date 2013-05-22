package xg.dgiproxy;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class WSSecHandler implements CallbackHandler {

public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
                if (pc.getUsage() == WSPasswordCallback.DECRYPT || 
                    pc.getUsage() == WSPasswordCallback.SIGNATURE) {
                    // alias de la clave en el keystore
                    if ("prod.dgi.gub.uy".equals(pc.getIdentifier())) {
                        pc.setPassword("pep1to");
                    }
                } 
            }
        }


	}

}
