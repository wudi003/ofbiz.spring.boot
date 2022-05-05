package org.apache.ofbiz;

import org.apache.ofbiz.base.component.ComponentConfig;
import org.apache.ofbiz.base.config.StreamResourceHandler;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.DelegatorFactory;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.List;

public class T {

	public static void main(String[] args) throws IOException {
		
		
		Resource[] entitymodels = new PathMatchingResourcePatternResolver().getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/entity/entitydef/entitymodel*.xml");
		for (Resource resource : entitymodels) {
			ComponentConfig.addEntityResourceHandler(new StreamResourceHandler("model", resource.getFilename(), resource.getInputStream(), resource.getURL()));
		}
		
		//Resource[] entitymodels = new PathMatchingResourcePatternResolver().getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/entity/entitydef/entitymodel*.xml");
		
		
		try {
			Delegator delegator=DelegatorFactory.getDelegator(null);
			List<GenericValue> userlogins=delegator.findAll("UserLogin", false);
			for (GenericValue genericValue : userlogins) {
				System.out.println(genericValue);
			}
			delegator.create("UserLogin","userLoginId", "wanglp");
		} catch (GenericEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
