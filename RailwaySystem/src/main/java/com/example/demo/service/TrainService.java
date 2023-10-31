package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Train;
import com.example.demo.repository.TrainRepository;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepository;

    public Iterable<Train> getAllTrains() {
    	Iterable<Train> Trains=trainRepository.findAll();
		return Trains;
    }
  
      
      public void addTrain(Train train) {
          trainRepository.save(train);
      }
   
      public Train addTrain(String trainNumber, String trainName, String startPoint, String endPoint,String departureTime) {
          Train train = new Train();
          train.setTrain_number(trainNumber);
          train.setTrain_name(trainName);
          train.setStart_point(startPoint);
          train.setEnd_point(endPoint);
          train.setDeparture_time(departureTime);
   
          return trainRepository.save(train);
      }
   
   
}

