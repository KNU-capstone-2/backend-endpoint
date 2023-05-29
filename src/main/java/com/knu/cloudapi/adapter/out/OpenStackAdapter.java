package com.knu.cloudapi.adapter.out;

import com.knu.cloudapi.application.dto.openstack.request.PostOpenStackKeypairRequest;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackFlavorResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackImageResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackKeypairResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackNetworkResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackProjectResponse;
import com.knu.cloudapi.application.dto.openstack.response.OpenStackInstanceControlResponse;
import com.knu.cloudapi.application.dto.openstack.response.PostOpenStackKeypairResponse;
import com.knu.cloudapi.application.port.out.OpenStackPort;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@NoArgsConstructor
public class OpenStackAdapter implements OpenStackPort {

    private final String openStackURL = "http://43.201.133.78:8000";

    @Override
    public GetOpenStackProjectResponse getProject() {
        return new RestTemplate()
            .getForObject(openStackURL+"/project", GetOpenStackProjectResponse.class);
    }

    @Override
    public GetOpenStackFlavorResponse getFlavor(String id) {
        return new RestTemplate()
            .getForObject(openStackURL+"/flavor/"+id, GetOpenStackFlavorResponse.class);
    }

    @Override
    public List<GetOpenStackFlavorResponse> getFlavorList() {
        return new RestTemplate().exchange(
            openStackURL+"/flavors",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<GetOpenStackFlavorResponse>>() {}
        ).getBody();
    }

    @Override
    public GetOpenStackNetworkResponse getNetwork(String id) {
        return new RestTemplate()
            .getForObject(openStackURL+"/network/"+id, GetOpenStackNetworkResponse.class);
    }

    @Override
    public List<GetOpenStackNetworkResponse> getNetworkList() {
        return new RestTemplate().exchange(
            openStackURL+"/networks",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<GetOpenStackNetworkResponse>>() {}
        ).getBody();
    }

    @Override
    public GetOpenStackImageResponse getImage(String id) {
        return new RestTemplate()
            .getForObject(openStackURL+"/image/"+id, GetOpenStackImageResponse.class);
    }

    @Override
    public List<GetOpenStackImageResponse> getImageList() {
        return new RestTemplate().exchange(
            openStackURL+"/images",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<GetOpenStackImageResponse>>() {}
        ).getBody();
    }

    @Override
    public GetOpenStackKeypairResponse getKeypair(String id) {
        return new RestTemplate()
            .getForObject(openStackURL+"/keypair/"+id, GetOpenStackKeypairResponse.class);
    }

    @Override
    public List<GetOpenStackKeypairResponse> getKeypairList() {
        return new RestTemplate().exchange(
            openStackURL+"/keypairs",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<GetOpenStackKeypairResponse>>() {}
        ).getBody();
    }

    @Override
    public PostOpenStackKeypairResponse postKeypair(String name, String type) {
        return new RestTemplate()
            .postForObject(
                openStackURL+"/keypair",
                new PostOpenStackKeypairRequest(name, type),
                PostOpenStackKeypairResponse.class);
    }

    @Override
    public String deleteKeypair(String id) {
        return new RestTemplate().exchange(
            openStackURL+"/keypair/"+id,
            HttpMethod.DELETE,
            null,
            String.class
        ).getBody();
    }

    @Override
    public OpenStackInstanceControlResponse startInstance(String id) {
        return new RestTemplate()
            .postForObject(
                openStackURL+"/instance/start/"+id,
                null,
                OpenStackInstanceControlResponse.class);
    }

    @Override
    public OpenStackInstanceControlResponse rebootInstance(String id) {
        return new RestTemplate()
            .postForObject(
                openStackURL+"/instance/reboot/"+id,
                null,
                OpenStackInstanceControlResponse.class);
    }

    @Override
    public OpenStackInstanceControlResponse stopInstance(String id) {
        return new RestTemplate()
            .postForObject(
                openStackURL+"/instance/stop/"+id,
                null,
                OpenStackInstanceControlResponse.class);
    }

}
