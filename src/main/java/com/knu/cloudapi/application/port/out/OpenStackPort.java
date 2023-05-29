package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackFlavorResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackImageResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackKeypairResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackNetworkResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackProjectResponse;
import com.knu.cloudapi.application.dto.openstack.response.PostOpenStackKeypairResponse;
import com.knu.cloudapi.domain.Instance;
import java.util.List;

public interface OpenStackPort {

    GetOpenStackProjectResponse getProject();

    GetOpenStackFlavorResponse getFlavor(String id);

    List<GetOpenStackFlavorResponse> getFlavorList();

    GetOpenStackNetworkResponse getNetwork(String id);

    List<GetOpenStackNetworkResponse> getNetworkList();

    GetOpenStackImageResponse getImage(String id);

    List<GetOpenStackImageResponse> getImageList();

    GetOpenStackKeypairResponse getKeypair(String id);

    List<GetOpenStackKeypairResponse> getKeypairList();

    PostOpenStackKeypairResponse postKeypair(String name, String type);

    String deleteKeypair(String id);


}
