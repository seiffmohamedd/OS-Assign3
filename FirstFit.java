import java.util.Scanner;

class FirstFit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int NumOfPartitions, PartitionSize[], NumOfProcess, ProcessSize[], ans = 0,PrintPartitons[],choice=0,ExternalFrag[];
        boolean check[];
        String PartitionName[], ProcessName[],NotAllocated[];

        System.out.println("Please enter Number of Partitions: ");
        NumOfPartitions = s.nextInt();

        PartitionSize = new int[NumOfPartitions];
        PartitionName = new String[NumOfPartitions];
        ExternalFrag=new int[NumOfPartitions*2];

        for (int i = 0; i < NumOfPartitions; i++) {
            System.out.println("Please enter Name of Partition " + (i+1) + ": ");
            PartitionName[i] = s.next();
            System.out.println("Please enter Size of Partition " + (i+1) + ": ");
            PartitionSize[i] = s.nextInt();
            ExternalFrag[i]=PartitionSize[i];

        }


        System.out.println("Please enter Number of Process Requests: ");
        NumOfProcess = s.nextInt();
        ProcessSize = new int[NumOfProcess];
        ProcessName = new String[NumOfProcess];

        for (int i = 0; i < NumOfProcess; i++) {
            System.out.println("Please enter Name of Process " + (i+1) + ": ");
            ProcessName[i] = s.next();
            System.out.println("Please enter Size of Process " + (i+1) + ": ");
            ProcessSize[i] = s.nextInt();
        }

        PrintPartitons = new int[NumOfPartitions];
        check=new boolean[NumOfPartitions];
        NotAllocated= new String[NumOfProcess];
        for (int i =0 ; i< NumOfPartitions;i++)
        {
            PrintPartitons[i]=0;
            check[i]=false;
            if( i<NumOfProcess)
            {
                NotAllocated[i]=" ";
            }
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
                    NotAllocated[i]=ProcessName[i];
                    ExternalFrag[j]=sub;
                    i++;
                    j=0;


                }
            }

        }

        for (int i=0 ; i < NumOfPartitions;i++)
        {
            if(PrintPartitons[i]==0)
            {
                System.out.println(PartitionName[i]+" "+PartitionSize[i]+ " "+"=> "+ "External Fragmentation");

            }
            else {
                System.out.println(PartitionName[i]+" "+PartitionSize[i]+ " "+"=> "+PrintPartitons[i]);
            }
        }

        for (int i=0 ; i < NumOfProcess;i++)
        {
            if(i<NumOfProcess && NotAllocated[i]==" " )
            {
                System.out.println(ProcessName[i] +" "+ "Cannot be Allocated");
            }
        }


//
//        System.out.println("Do you want to compact? 1.yes 2.no");
//        choice= s.nextInt();
//        if(choice==1)
//        {
//
//
//        }
//        else {return;}



    }
}