package com.si.igame.contact;

import com.si.igame.entity.Entity;

public interface Contact 
{
    public void onContact(Entity e);
    
    public boolean isContact(Entity e);
}
