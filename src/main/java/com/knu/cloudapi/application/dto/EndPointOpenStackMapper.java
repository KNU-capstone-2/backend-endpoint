package com.knu.cloudapi.application.dto;

import com.knu.cloudapi.application.dto.openstack.response.*;
import com.knu.cloudapi.application.dto.request.PostKeypairRequest;
import com.knu.cloudapi.application.dto.response.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EndPointOpenStackMapper {

    GetFlavorResponse transGetFlavorRes(GetOpenStackFlavorResponse response);

    GetNetworkResponse transGetNetworkRes(GetOpenStackNetworkResponse response);

    GetKeypairResponse transGetKeypairRes(GetOpenStackKeypairResponse response);

    GetImageResponse transGetImageRes(GetOpenStackImageResponse response);

    PostKeypairResponse transPostKeypairRes(PostOpenStackKeypairResponse response);

    PostKeypairRequest transPostKeypairReq(PostKeypairRequest request);

    GetProjectResponse transGetProjectRes(GetOpenStackProjectResponse response);
}
