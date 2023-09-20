package nl.utwente.ss.ss2mlactivitydetectiontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import weka.classifiers.Classifier;
import weka.core.*;
import weka.core.converters.ConverterUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            InputStream modelIs = this.getAssets().open("90PercentJ48UnfilteredLeftPocket.model");
            ObjectInputStream ois = new ObjectInputStream(modelIs);
            Classifier classifier = (Classifier) ois.readObject();
            ois.close();

//            InputStream csvIs = this.getAssets().open("header.csv");
//            ConverterUtils.DataSource dataSource = new ConverterUtils.DataSource(csvIs);
//            Instances instances = dataSource.getDataSet();

            ArrayList<Attribute> attributeList = new ArrayList<>();
            attributeList.add(new Attribute("Left_pocket_Ax"));
            attributeList.add(new Attribute("Left_pocket_Ay"));
            attributeList.add(new Attribute("Left_pocket_Az"));
            attributeList.add(new Attribute("Left_pocket_Lx"));
            attributeList.add(new Attribute("Left_pocket_Ly"));
            attributeList.add(new Attribute("Left_pocket_Lz"));
            attributeList.add(new Attribute("Left_pocket_Gx"));
            attributeList.add(new Attribute("Left_pocket_Gy"));
            attributeList.add(new Attribute("Left_pocket_Gz"));
            attributeList.add(new Attribute("Left_pocket_Mx"));
            attributeList.add(new Attribute("Left_pocket_My"));
            attributeList.add(new Attribute("Left_pocket_Mz"));
            ArrayList<String> activities = new ArrayList<>();
            activities.add("biking");
            activities.add("downstairs");
            activities.add("jogging");
            activities.add("sitting");
            activities.add("standing");
            activities.add("upstairs");
            activities.add("walking");
            attributeList.add(new Attribute("Activity", activities));

            Instances dataset = new Instances("NewData", attributeList, 0);
            dataset.setClassIndex(attributeList.size() - 1);

            DenseInstance newInstance = new DenseInstance(attributeList.size());
            newInstance.setValue(0,-0.70826);
            newInstance.setValue(1,0.70826);
            newInstance.setValue(2,-9.3572);
            newInstance.setValue(3,-0.0062824);
            newInstance.setValue(4,-0.065935);
            newInstance.setValue(5,0.39363);
            newInstance.setValue(6,-0.0076358);
            newInstance.setValue(7,0.0018326);
            newInstance.setValue(8,-0.0051924);
            newInstance.setValue(9,-10.5);
            newInstance.setValue(10,-4.8);
            newInstance.setValue(11,35.46);
//            newInstance.setValue(0,-0.70826);
//            newInstance.setValue(1,0.70826);
//            newInstance.setValue(2,-9.3572);
//            newInstance.setValue(3,-0.0062824);
//            newInstance.setValue(4,-0.065935);
//            newInstance.setValue(5,0.39363);
//            newInstance.setValue(6,-0.0076358);
//            newInstance.setValue(7,0.0018326);
//            newInstance.setValue(8,-0.0051924);
//            newInstance.setValue(9,-10.5);
//            newInstance.setValue(10,-4.8);
//            newInstance.setValue(11,35.46);




            dataset.add(newInstance);

            double classLabel = classifier.classifyInstance(dataset.instance(0));

            System.out.println("We got: <" + classLabel + ">");
            Log.i("GOTHIM", String.valueOf(classLabel));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}