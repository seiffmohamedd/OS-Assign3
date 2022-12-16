import java.util.LinkedList;
import java.util.Scanner;

class FirstFit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int NumOfPartitions, PartitionSize[], NumOfProcess, ProcessSize[], ans = 0,choice=0,ExternalFrag[],ctr=0;
        boolean check[];
        String PartitionName[], ProcessName[],NotAllocated[];
        LinkedList<Integer> NewPart = new LinkedList<Integer>();
        LinkedList<Integer> PrintPartitons = new LinkedList<Integer>();
        LinkedList<String> PrintName = new LinkedList<String>();


        System.out.println("Please enter Number of Partitions: ");
        NumOfPartitions = s.nextInt();

        PartitionSize = new int[NumOfPartitions];
        PartitionName = new String[NumOfPartitions];
//        ExternalFrag=new int[NumOfPartitions*2];

        for (int i = 0; i < NumOfPartitions; i++) {
            System.out.println("Please enter Name of Partition " + (i+1) + ": ");
            PartitionName[i] = s.next();
            System.out.println("Please enter Size of Partition " + (i+1) + ": ");
            PartitionSize[i] = s.nextInt();
//            ExternalFrag[i]=PartitionSize[i];

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

        check=new boolean[NumOfPartitions];

        NotAllocated= new String[NumOfProcess];

        for (int i =0 ; i< NumOfPartitions;i++)
        {
            PrintPartitons.add(0);
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
                if(ctr!=NumOfPartitions){
                    NewPart.add( PartitionSize[j]);
                    ctr++;
                }
                if(ProcessSize[i]<= NewPart.get(j) &&check[j]==false)
                {
                    int sub=NewPart.get(j)-ProcessSize[i];
                    PrintPartitons.add(j,ProcessSize[i]);
                    NewPart.add(j+1, sub);
//                    PrintName.add(ProcessName[i]);
                    check[j]=true;
                    NotAllocated[i]=ProcessName[i];
                    i++;
                    j=0;

                }
            }

        }

//        for (int i=0 ; i < NumOfPartitions;i++)
        int ctrr=0;
        for (int i=0 ; i < PrintPartitons.size();i++)
        {

            if(PrintPartitons.get(i) ==0)
            {
//                System.out.println(PartitionName[i]+" "+PartitionSize[i]+ " "+"=> "+ "External Fragmentation"); //DONE
                System.out.println(PrintPartitons.get(i)+ " "+"=> "+ "External Fragmentation"); //DONE


            }
            else {
//                System.out.println(PartitionName[i]+" "+PrintPartitons.get(i)+ " "+"=> "+ ProcessName[i]);
                System.out.println(PrintPartitons.get(i));
                ctrr++;
            }
        }

        for (int i=0 ; i < NumOfProcess;i++)
        {
            if(NotAllocated[i]==" " )
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