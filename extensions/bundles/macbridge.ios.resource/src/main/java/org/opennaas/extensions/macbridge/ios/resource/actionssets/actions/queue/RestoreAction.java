package org.opennaas.extensions.macbridge.ios.resource.actionssets.actions.queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opennaas.core.resources.action.Action;
import org.opennaas.core.resources.action.ActionException;
import org.opennaas.core.resources.action.ActionResponse;
import org.opennaas.core.resources.protocol.IProtocolSessionManager;
import org.opennaas.core.resources.queue.QueueConstants;

public class RestoreAction extends Action {

	static Log	log	= LogFactory.getLog(RestoreAction.class);

	public RestoreAction() {
		super();
		this.setActionID(QueueConstants.RESTORE);

	}

	@Override
	public ActionResponse execute(IProtocolSessionManager protocolSessionManager) throws ActionException {
		ActionResponse actionResponse = ActionResponse.okResponse(actionID);
		return actionResponse;
	}

	@Override
	public boolean checkParams(Object params) throws ActionException {
		return true;
	}

}
