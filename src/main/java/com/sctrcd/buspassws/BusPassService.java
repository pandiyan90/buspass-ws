package com.sctrcd.buspassws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sctrcd.buspassws.facts.BusPass;
import com.sctrcd.buspassws.facts.Person;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BusPassService {

    @Autowired
    private KieContainer kieContainer;

    public BusPass getBusPass(Person person) {
        KieSession kieSession = kieContainer.newKieSession("BusPassSession");
        kieSession.insert(person);
        kieSession.fireAllRules();
        BusPass busPass = findBusPass(kieSession);
        kieSession.dispose();
        return busPass;
    }
    
    private BusPass findBusPass(KieSession kieSession) {
        
        ObjectFilter busPassFilter = new ObjectFilter() {
            @Override
            public boolean accept(Object object) {
            	boolean result = false;
                if (BusPass.class.equals(object.getClass()))
                	result=true;
                else if (BusPass.class.equals(object.getClass().getSuperclass())) 
                	result=true;
                return result;
            }
        };

        List<BusPass> facts = new ArrayList<>();
        for (FactHandle handle : kieSession.getFactHandles(busPassFilter)){
        	log.info(handle.toString());
            facts.add((BusPass) kieSession.getObject(handle));
        }
        if (facts.isEmpty())
        	return null;
        return facts.get(0);
    }
    
    @SuppressWarnings("unused")
    private void printFactsMessage(KieSession kieSession) {
        Collection<FactHandle> allHandles = kieSession.getFactHandles();
        
        String msg = "\nAll facts:\n";
        for (FactHandle handle : allHandles)
            msg += "    " + kieSession.getObject(handle) + "\n";
        
        log.info(msg);
    }

}