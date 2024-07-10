package com.studymavenspringboot1.rentcar.vehicletype;

import java.util.List;

public interface IVehicleTypeService {
    IVehicleType findById(Long id);
    IVehicleType findByType(String type);
    List<IVehicleType> getAllList();
    IVehicleType insert(IVehicleType vehicleType) throws Exception;
    boolean remove(Long id) throws Exception;
    IVehicleType update(Long id, IVehicleType vehicleType) throws Exception;
    List<IVehicleType> findAllByTypeContains(String type);
    List<IVehicleType> getListFromName(String findType);

}
