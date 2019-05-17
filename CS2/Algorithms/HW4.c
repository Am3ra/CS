#include <stdio.h>
#include "LinkedList.h" //Libreria propia

typedef struct AdjacentNodeStruct
{
    int neighbor_id;
    int weight;
} AdjacencyNode;

typedef struct GraphNodeStruct
{
    int id;
    int visited;
    Node *Adjacency_List;
} GraphNode;

AdjacencyNode *createNeighbor(int id, int weight)
{
    AdjacencyNode *temp = calloc(1, sizeof(AdjacencyNode));
    temp->neighbor_id = id;
    temp->weight = weight;
    return temp;
}

void AppendNewNeighbor(GraphNode *node, int id, int weight)
{
    appendNode(node, createNeighbor(id, weight));
}

Node *GetNeighbors(GraphNode *node)
{
    return node->Adjacency_List;
}

Node *ComponentesConexos(GraphNode nodeArray[])
{
    //Avoid extra argument, find size of array
    int length = sizeof(nodeArray)/sizeof(nodeArray[0]);

    for (int i = 0; i < length; i++)
    {
        if (nodeArray[i].visited)
        {
            continue;
        }
        else
        {
            
        }
        
    }
    
}