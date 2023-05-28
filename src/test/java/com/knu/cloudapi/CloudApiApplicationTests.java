package com.knu.cloudapi;

import com.knu.cloudapi.adapter.out.OpenStackAdapter;
import com.knu.cloudapi.application.dto.openstack.response.GetOpenStackKeypairResponse;
import com.knu.cloudapi.application.dto.openstack.response.PostOpenStackKeypairResponse;
import com.knu.cloudapi.application.port.out.OpenStackPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CloudApiApplicationTests {

  private OpenStackPort openStackPort;

  @BeforeEach
  public void beforeEach() {
    this.openStackPort = new OpenStackAdapter();
  }

  @Test
  void openStackAdapterKeypairTest() {
    PostOpenStackKeypairResponse response1 = openStackPort.postKeypair("hi", "ssh");
    Assertions.assertEquals("hi", response1.getName());

    GetOpenStackKeypairResponse response2 = openStackPort.getKeypair("hi");
    Assertions.assertEquals("hi", response2.getName());

    String response3 = openStackPort.deleteKeypair("hi");
    Assertions.assertEquals("success", response3);
  }

}
