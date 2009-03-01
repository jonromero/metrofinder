# Prototype
# Jon Vlachoyiannis
# 01/03/2009

def main():
    nodes_green = ["Peiraias", "Falhro", "Mosxato", "Tauros", "Petralona", "Thiseio", "Monasthraki", "Omonoia", "Panepistimio", "Viktoria", "Attikh", "Agios Nikolaos", "Katw Pathsia", "Agios Eleu8erios", "Perissos", "Peukakia", "Nea Ionia", "Irakleio", "Eirhnh", "Neratziotisa", "Marousi", "KAT", "Khfisia"]
    
    nodes_blue = ["Aigalew", "Elaiwnas", "Keramaikos", "Monastiraki", "Syntagma", "Euagelismos", "Abelokhpoi", "Panormou", "Katexakh", "E8nikh Amuna", "Xalandri", "Doukisshs Plakentias", "???", "Painia-Kantza", "Korwpi"]
    
    nodes_red = ["Agios Dhmitrios", "Dafnh", "Agios Ioannis", "Neos Kosmos", "Suggrou-Fix", "Akropolh", "Sudagma", "Panepisthmio", "Omonoia", "Metaxourgio", "Sta8mos Larisshs", "Attikh", "Sepolia", "Agios Adwnios"]
    
    nd_intersec_green_blue = 6
    nd_intersec_blue_green = 3
    nd_intersec_red_blue = 6
    nd_intersec_blue_red = 4
    nd_intersec_red_green = 8
    nd_intersec_green_red = 8

    
    node_start = 8
    node_color_start = 1
    node_end = 10
    node_color_end = 2
    
    print "Starting from", nodes_blue[node_start]
    print "End at", nodes_red[node_end]

    n = 0
    n1 = 0
    n2 = 0
    
    if node_color_start == node_color_end:
        n = calcTotalNodes(node_start, node_end)

    # Green/Blue
    elif node_color_start == 0 and node_color_end == 1:
        n1 = calcTotalNodes(node_start, nd_intersec_green_blue)
        n2 = calcTotalNodes(nd_intersec_blue_green, node_end)
        n = abs(n1) + abs(n2)
        print n1,n2

    # Blue/Green
    elif node_color_start == 1 and node_color_end == 0:  
        n1 = calcTotalNodes(node_start, nd_intersec_blue_green)
        n2 = calcTotalNodes(nd_intersec_green_blue, node_end)
        n = abs(n1) + abs(n2)
        print n1,n2

    # Green/Red
    elif node_color_start == 0 and node_color_end == 2:
        n1 = calcTotalNodes(node_start, nd_intersec_green_blue)
        n2 = calcTotalNodes(nd_intersec_blue_green, node_end)
        n = abs(n1) + abs(n2)
        print n1,n2

    # Red/Green
    elif node_color_start == 2 and node_color_end == 0:  
        n1 = calcTotalNodes(node_start, nd_intersec_red_green)
        n2 = calcTotalNodes(nd_intersec_green_red, node_end)
        n = abs(n1) + abs(n2)
        print n1,n2

    # Blue/Red
    elif node_color_start == 1 and node_color_end == 2:
        n1 = calcTotalNodes(node_start, nd_intersec_blue_red)
        n2 = calcTotalNodes(nd_intersec_red_blue, node_end)
        n = abs(n1) + abs(n2)
        print n1,n2

    # Red/Blue
    elif node_color_start == 2 and node_color_end == 1:  
        n1 = calcTotalNodes(node_start, nd_intersec_red_blue)
        n2 = calcTotalNodes(nd_intersec_blue_red, node_end)
        n = abs(n1) + abs(n2)
        print n1,n2

    return n

def calcTotalNodes(nd_start, nd_end):
    return nd_end - nd_start


print "Total nodes:", main()
