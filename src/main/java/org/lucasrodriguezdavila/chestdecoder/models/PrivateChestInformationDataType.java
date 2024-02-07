package org.lucasrodriguezdavila.chestdecoder.models;

import org.apache.commons.lang3.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class PrivateChestInformationDataType implements PersistentDataType<byte[], PrivateChestInformation> {
    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @Override
    public Class<PrivateChestInformation> getComplexType() {
        return PrivateChestInformation.class;
    }

    @Override
    public byte[] toPrimitive(PrivateChestInformation privateChestInformation, PersistentDataAdapterContext persistentDataAdapterContext) {
        return SerializationUtils.serialize(privateChestInformation);
    }

    @Override
    public PrivateChestInformation fromPrimitive(byte[] primitive, PersistentDataAdapterContext persistentDataAdapterContext) {
        try {
            InputStream is = new ByteArrayInputStream(primitive);
            ObjectInputStream o = new ObjectInputStream(is);

            return (PrivateChestInformation) o.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
        
    }
}
