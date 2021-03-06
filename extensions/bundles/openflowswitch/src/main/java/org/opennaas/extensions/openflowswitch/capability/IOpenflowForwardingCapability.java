package org.opennaas.extensions.openflowswitch.capability;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.opennaas.core.resources.capability.CapabilityException;
import org.opennaas.core.resources.capability.ICapability;
import org.opennaas.extensions.openflowswitch.model.FloodlightOFFlow;
import org.opennaas.extensions.openflowswitch.model.OFFlow;
import org.opennaas.extensions.openflowswitch.model.OpenDaylightOFFlow;

/**
 *
 * @author Adrian Rosello (i2CAT)
 *
 */
@Path("/")
public interface IOpenflowForwardingCapability extends ICapability {

    @POST
    @Path("/createOFFForwardingRule")
    @Consumes(MediaType.APPLICATION_XML)
    public void createOpenflowForwardingRule(FloodlightOFFlow forwardingRule) throws CapabilityException;

    @DELETE
    @Path("/removeOFForwardingRule/{flowId}")
    @Consumes(MediaType.APPLICATION_XML)
    public void removeOpenflowForwardingRule(String DPID, @PathParam("flowId") String flowId) throws CapabilityException;

    @GET
    @Path("/getOFForwardingRules")
    @Produces(MediaType.APPLICATION_XML)
    public List<OFFlow> getOpenflowForwardingRules() throws CapabilityException;

    @POST
    @Path("/createOFFForwardingRule")
    @Consumes(MediaType.APPLICATION_XML)
    public void createOpenflowForwardingRule(OpenDaylightOFFlow forwardingRule) throws CapabilityException;

    @GET
    @Path("/getOFForwardingRules/{flowId}")
    @Produces(MediaType.APPLICATION_XML)
    public OpenDaylightOFFlow getOpenflowForwardingRule(String DPID, @PathParam("flowId") String flowId) throws CapabilityException;

}
