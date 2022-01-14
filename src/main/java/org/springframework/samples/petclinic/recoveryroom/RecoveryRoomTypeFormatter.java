package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	
	private final RecoveryRoomService recoveryRoomService;
	
	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	
    	Iterable<RecoveryRoomType> recovery_room_types = this.recoveryRoomService.getAllRecoveryRoomTypes();
		
    	for(RecoveryRoomType recovery_room_type: recovery_room_types) {
			if(recovery_room_type.getName().equals(text))
				return recovery_room_type;
		}
    	
		throw new ParseException("recovery room type not found: " + text, 0);
   
    }
    
}
