package cs1660_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



import com.google.cloud.dataproc.v1.JobPlacement;

import java.io.*;
import java.util.*;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.HadoopJob;
import com.google.cloud.dataproc.v1.Job;
import com.google.cloud.dataproc.v1.JobControllerClient;
import com.google.cloud.dataproc.v1.JobControllerSettings;
import com.google.cloud.dataproc.v1.JobMetadata;

public class gui
{
    public static void main(String[] args)
    {
        gui2 test = new gui2();
    }
}
class gui2 implements ActionListener //initial page
{
    private enum Actions {BUTTON, BUTTON2}
    JFrame frame;
    File[] files;
    public gui2()
    {
        frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Choose Files");
        JButton button2 = new JButton("Construct Inverted Indices");
        JLabel label = new JLabel("Load My Engine");
        button.setActionCommand(Actions.BUTTON.name());
        button.addActionListener(this);
        button2.setActionCommand(Actions.BUTTON2.name());
        button2.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);
        panel.add(button2);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("tjc98 Search Engine");
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getActionCommand() == Actions.BUTTON.name())
        {
            JButton open = new JButton();
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Select Files");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.setMultiSelectionEnabled(true);
            if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION)
            {

            }
            files = fc.getSelectedFiles();
        }
        else if(a.getActionCommand() == Actions.BUTTON2.name())
        {
            String projectID = "gifted-cooler-309612";
            String region = "us-central1";
            String cluster = "cluster-ddee";
            String query = "WordCount /inputData /output";
            StartJob(projectID, region, cluster, query);
            frame.setVisible(false);
            gui3 gui = new gui3();
        }
    }
    public static void StartJob(String projectID, String region, String cluster, String query)
    {
        try
        {
        	JobControllerSettings settings = JobControllerSettings.newBuilder().setEndpoint(region + "-dataproc.googleapis.com:443").build(); //job settings
            JobControllerClient client = JobControllerClient.create(settings); //job client
            JobPlacement placement = JobPlacement.newBuilder().setClusterName(cluster).build(); //job location
            ArrayList<String> vals = new ArrayList<>(Arrays.asList(query.split(" ")));
            HadoopJob job = HadoopJob.newBuilder().setMainClass("dataproc-staging-us-central1-93082407233-zaeells1/wc.jar").addAllArgs(vals).build();
            Job job2 = Job.newBuilder().setPlacement(placement).setHadoopJob(job).build();
            OperationFuture<Job, JobMetadata> response = client.submitJobAsOperationAsync(projectID, region, job2);
        }
        catch(IOException e)
        {
            System.out.println("Error");
            System.exit(1);
        }
    }
}
class gui3 implements ActionListener //indices constructed page
{
    private enum Actions {BUTTON, BUTTON2}
    JFrame frame;
    public gui3()
    {
        frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Engine was loaded");
        JLabel label2 = new JLabel("&");
        JLabel label3 = new JLabel("Inverted indices were constructed successfully");
        JLabel label4 = new JLabel("Please Select Action");
        JButton button = new JButton("Search for Term");
        JButton button2 = new JButton("Top-N");
        button.setActionCommand(Actions.BUTTON.name());
        button.addActionListener(this);
        button2.setActionCommand(Actions.BUTTON2.name());
        button2.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(button);
        panel.add(button2);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("tjc98 Search Engine");
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getActionCommand() == Actions.BUTTON.name())
        {
            frame.setVisible(false);
            gui4 gui = new gui4();
        }
        else if(a.getActionCommand() == Actions.BUTTON2.name())
        {
            frame.setVisible(false);
            gui5 gui = new gui5();
        }
    }
}
class gui4 implements ActionListener //word search page
{
    private enum Actions {BUTTON}
    JFrame frame;
    public gui4()
    {
        frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your Search Term");
        JTextField text = new JTextField("Type Your Search Here");
        JButton button = new JButton("Search");
        button.setActionCommand(Actions.BUTTON.name());
        button.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(text);
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("tjc98 Search Engine");
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getActionCommand() == Actions.BUTTON.name())
        {
            frame.setVisible(false);
            //gui6 gui = new gui6();
        }
    }
}
class gui5 implements ActionListener //n-top search page
{
    private enum Actions {BUTTON}
    JFrame frame;
    public gui5()
    {
        frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your N Value");
        JTextField text = new JTextField("Type Your N Here");
        JButton button = new JButton("Search");
        button.setActionCommand(Actions.BUTTON.name());
        button.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(text);
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("tjc98 Search Engine");
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getActionCommand() == Actions.BUTTON.name())
        {
            frame.setVisible(false);
            //gui7 gui = new gui7();
        }
    }
}