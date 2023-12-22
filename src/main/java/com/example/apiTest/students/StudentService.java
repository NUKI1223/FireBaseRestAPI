package com.example.apiTest.students;

import com.google.api.core.ApiFuture;
import com.google.api.services.storage.Storage;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.protobuf.Api;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class StudentService {


    private static final String COLLECTION_NAME ="students" ;

    public List<Student> list() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        List<Student> dataList = new ArrayList<>();

        CollectionReference dataCollection = dbFirestore.collection(COLLECTION_NAME);

        ApiFuture<QuerySnapshot> querySnapshot = dataCollection.get();

        for (QueryDocumentSnapshot document : querySnapshot.get().getDocuments()) {

            Student student = document.toObject(Student.class);

            dataList.add(student);
        }

        return dataList;

    }


    public String add(Student student) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionAPI = dbFirestore.collection(COLLECTION_NAME).document(student.getName()).set(student);
        return collectionAPI.get().getUpdateTime().toString();
    }

}
