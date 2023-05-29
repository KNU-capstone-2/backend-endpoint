package com.knu.cloudapi.application.port.in;

import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackProjectResponse;
import com.knu.cloudapi.application.dto.request.PostKeypairRequest;
import com.knu.cloudapi.application.dto.response.*;

import java.util.List;

public interface InstanceOptionsUsecase {
    List<GetFlavorResponse> getFlavorList();

    GetFlavorResponse getFlavorById(String id);

    List<GetImageResponse> getImageList();

    GetImageResponse getImageById(String id);

    List<GetKeypairResponse> getKeypairList();

    GetKeypairResponse getKeypairById(String id);

    List<GetNetworkResponse> getNetworkList();

    GetNetworkResponse getNetworkById(String id);

    PostKeypairResponse postKeypair(PostKeypairRequest request);

    GetProjectResponse getOpenStackProject();

    String deleteKeypair(String id);
}
