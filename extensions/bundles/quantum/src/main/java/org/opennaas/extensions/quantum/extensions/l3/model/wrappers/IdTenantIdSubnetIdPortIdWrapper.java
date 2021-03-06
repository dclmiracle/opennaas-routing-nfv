package org.opennaas.extensions.quantum.extensions.l3.model.wrappers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Add Interface Quantum L3 Extension Message Wrapper.<br/>
 * Designed to store Quantum L3 Extension request or response.<br/>
 * Based on <a href="http://docs.openstack.org/api/openstack-network/2.0/content/router_add_interface.html">Openstack Networking API v2.0 L3
 * Extension.</a>
 * 
 * @author Julio Carlos Barrera
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IdTenantIdSubnetIdPortIdWrapper {

	private String	id;
	private String	tenant_id;
	private String	subnet_id;
	private String	port_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}

	public String getSubnet_id() {
		return subnet_id;
	}

	public void setSubnet_id(String subnet_id) {
		this.subnet_id = subnet_id;
	}

	public String getPort_id() {
		return port_id;
	}

	public void setPort_id(String port_id) {
		this.port_id = port_id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdTenantIdSubnetIdPortIdWrapper other = (IdTenantIdSubnetIdPortIdWrapper) obj;
		if (!id.equals(other.getId()))
			return false;
		if (!tenant_id.equals(other.getTenant_id()))
			return false;
		if (!subnet_id.equals(other.getSubnet_id()))
			return false;
		if (!port_id.equals(other.getPort_id()))
			return false;
		return true;
	}

}
