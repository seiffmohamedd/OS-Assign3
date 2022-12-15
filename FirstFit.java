import java.util.Scanner;

class FirstFit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int NumOfPartitions, PartitionSize[], NumOfProcess, ProcessSize[], ans = 0,PrintPartitons[];
        boolean check[];
        String PartitionName[], ProcessName[];

        System.out.println("Please enter Number of Partitions: ");
        NumOfPartitions = s.nextInt();

        PartitionSize = new int[NumOfPartitions];
        PartitionName = new String[NumOfPartitions];
        for (int i = 0; i < NumOfPartitions; i++) {
            System.out.println("Please enter Size of Partition " + (i+1) + ": ");
            PartitionSize[i] = s.nextInt();
        }


        System.out.println("Please enter Number of Process Requests: ");
        NumOfProcess = s.nextInt();
        ProcessSize = new int[NumOfProcess];
        ProcessName = new String[NumOfProcess];

        for (int i = 0; i < NumOfProcess; i++) {
            System.out.println("Please enter Size of Process " + (i+1) + ": ");
            ProcessSize[i] = s.nextInt();
        }

        PrintPartitons = new int[NumOfPartitions];
        check=new boolean[NumOfPartitions];

        for (int i =0 ; i< NumOfPartitions;i++)
        {
            PrintPartitons[i]=0;
            check[i]=false;
        }

        for (int i =0 ; i < NumOfProcess;i++)
        {
            for (int j =0 ; j < NumOfPartitions ; j++)
            {
                if(ProcessSize[i]<=PartitionSize[j]&&check[j]==false)
                {
                    int sub=PartitionSize[j]-ProcessSize[i];
                    PrintPartitons[j]=ProcessSize[i];
                    ans+=sub;
                    check[j]=true;
                    i++;
                    j=0;
                }
            }
        }

        for (int i=0 ; i < NumOfPartitions;i++)
        {
            System.out.println("Process "+(i+1)+ " "+PrintPartitons[i]);
        }


    }
}