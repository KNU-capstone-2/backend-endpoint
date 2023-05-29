package com.knu.cloudapi.application.dto;

import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackFlavorResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackImageResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackKeypairResponse;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackNetworkResponse;
import com.knu.cloudapi.application.dto.openstack.response.PostOpenStackKeypairResponse;
import com.knu.cloudapi.application.dto.request.PostKeypairRequest;
import com.knu.cloudapi.application.dto.response.GetFlavorResponse;
import com.knu.cloudapi.application.dto.response.GetImageResponse;
import com.knu.cloudapi.application.dto.response.GetKeypairResponse;
import com.knu.cloudapi.application.dto.response.GetNetworkResponse;
import com.knu.cloudapi.application.dto.response.PostKeypairResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EndPointOpenStackMapper {

    GetFlavorResponse transGetFlavorRes(GetOpenStackFlavorResponse response);

    GetNetworkResponse transGetNetworkRes(GetOpenStackNetworkResponse response);

    GetKeypairResponse transGetKeypairRes(GetOpenStackKeypairResponse response);

    GetImageResponse transGetImageRes(GetOpenStackImageResponse response);

    PostKeypairResponse transPostKeypairRes(PostOpenStackKeypairResponse response);
}
