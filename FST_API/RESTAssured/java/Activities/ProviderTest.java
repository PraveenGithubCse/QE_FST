package Activities;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

@Provider("userprovider")
@PactFolder("target/pacts")
//@PactBroker(host="ibm.pactflow.io")
//@PactUrl(urls="https://aws")
public class ProviderTest {
	//set the target
	@BeforeEach
	public void setUp(PactVerificationContext context)
	{
		HttpTestTarget target=new HttpTestTarget("localhost",8585);
		context.setTarget(target);
	}
	
	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	public void verifyResponse(PactVerificationContext context)
	{
		//verify the interaction from the context 
		context.verifyInteraction();
	}
	
	//specify the interaction to test
	@State("POST request")
	public void state1()
	{
		
	}
}
