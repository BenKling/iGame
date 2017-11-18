package com.si.igame.contact;

import com.si.igame.entity.Entity;
import java.util.ArrayList;

public class ContactManager 
{
    private static ContactManager instance = null;
    private ArrayList<Entity> m_allEntities;

    protected ContactManager()
    {
        m_allEntities = new ArrayList<Entity>();
    }
    
    public static ContactManager getContactManager()
    {
        if(instance == null)
        {
            instance = new ContactManager();
        }
        
        return instance;
    }
    
    //Methods
    public void addEntity(Entity e)
    {
        m_allEntities.add(e);
    }
    
    public void removeEntity(Entity e)
    {
        m_allEntities.remove(e);
    }
    
    public void update()
    {
        for(int i = 0; i < m_allEntities.size(); ++i)
        {
            Entity e1 = m_allEntities.get(i);
            
            for(int j = i+1; j < m_allEntities.size(); ++j)
            {
                Entity e2 = m_allEntities.get(j);
                
                if(isContact(e1, e2))
                {
                    e1.onContact(e2);
                    e2.onContact(e1);
                }
            }
        }
    }
    
    private boolean isContact(Entity e1, Entity e2)
    {
        if(e1.getBounds().overlaps(e2.getBounds()))
        {
            return true;
        }
        
        return false;
    }
}
