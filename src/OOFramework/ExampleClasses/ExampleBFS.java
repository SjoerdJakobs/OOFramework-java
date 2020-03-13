package OOFramework.ExampleClasses;

import OOFramework.Pathfinding.BFS.BreathFirstSearch;

public class ExampleBFS {

    public void ShowBFS()
    {
        BreathFirstSearch BFS = new BreathFirstSearch();
        BFS.CreateTileGrid(25,25);

        for (int i =0; i<12; i++)
        {
            BFS.SetWall(3+i, 7);
        }
        for (int i =0; i<10; i++)
        {
            BFS.SetWall(3, 4+i);
        }

        BFS.Addroute(10,12,"route0");

        for (int j = 0; j < 25; j++)
        {
            System.out.println("");
            for (int i= 0; i < 25; i++)
            {
                if(BFS.getTileMap()[i][j].isDestination)
                {
                    System.out.print("X ");
                }
                else if(BFS.getTileMap()[i][j].isWall)
                {
                    System.out.print("H ");
                }else if(BFS.getTileMap()[i][j].routes.get("route0").x == 1)
                {
                    System.out.print("> ");
                }else if(BFS.getTileMap()[i][j].routes.get("route0").x == -1)
                {
                    System.out.print("< ");
                }else if(BFS.getTileMap()[i][j].routes.get("route0").y == 1)
                {
                    System.out.print("v ");
                }else if(BFS.getTileMap()[i][j].routes.get("route0").y == -1)
                {
                    System.out.print("^ ");
                }
                else
                {
                    System.out.print("o ");
                }
            }
        }
    }
}
