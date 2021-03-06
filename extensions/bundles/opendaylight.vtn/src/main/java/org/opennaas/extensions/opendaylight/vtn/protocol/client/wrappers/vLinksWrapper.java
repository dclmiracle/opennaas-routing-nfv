package org.opennaas.extensions.opendaylight.vtn.protocol.client.wrappers;

import java.util.ArrayList;
import org.opennaas.extensions.opendaylight.vtn.model.vLink;

/**
 * Object wrapper of ArrayList {@link vLinks} to allow custom JSON
 * deserialization
 *
 * @author Jospe Batallé
 */
public class vLinksWrapper extends ArrayList<vLink> {

    private static final long serialVersionUID = -3635412232071232706L;

}
