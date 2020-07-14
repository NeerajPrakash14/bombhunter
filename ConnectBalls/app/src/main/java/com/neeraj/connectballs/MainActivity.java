package com.neeraj.connectballs;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button newgraph_bt;
    Button node00, node01, node02, node03, node04, node10, node11, node12, node13, node14, node20, node21, node22, node23, node24, node30, node31, node32, node33, node34, node40, node41, node42, node43, node44, node50, node51, node52, node53, node54;
    public int x, y, i, n, t;
    int[] nodes;
    int[][] path;
    TextView display_graph;
    int[] level;
    boolean gameover;
    int correctcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        display_graph = findViewById(R.id.display_graph);
        newgraph_bt = findViewById(R.id.newgraph_bt);
        node00 = findViewById(R.id.node00);
        node01 = findViewById(R.id.node01);
        node02 = findViewById(R.id.node02);
        node03 = findViewById(R.id.node03);
        node04 = findViewById(R.id.node04);
        node10 = findViewById(R.id.node10);
        node11 = findViewById(R.id.node11);
        node12 = findViewById(R.id.node12);
        node13 = findViewById(R.id.node13);
        node14 = findViewById(R.id.node14);
        node20 = findViewById(R.id.node20);
        node21 = findViewById(R.id.node21);
        node22 = findViewById(R.id.node22);
        node23 = findViewById(R.id.node23);
        node24 = findViewById(R.id.node24);
        node30 = findViewById(R.id.node30);
        node31 = findViewById(R.id.node31);
        node32 = findViewById(R.id.node32);
        node33 = findViewById(R.id.node33);
        node34 = findViewById(R.id.node34);
        node40 = findViewById(R.id.node40);
        node41 = findViewById(R.id.node41);
        node42 = findViewById(R.id.node42);
        node43 = findViewById(R.id.node43);
        node44 = findViewById(R.id.node44);
        node50 = findViewById(R.id.node50);
        node51 = findViewById(R.id.node51);
        node52 = findViewById(R.id.node52);
        node53 = findViewById(R.id.node53);
        node54 = findViewById(R.id.node54);

        newgraph_bt.setOnClickListener(this);
        node00.setOnClickListener(this);
        node01.setOnClickListener(this);
        node02.setOnClickListener(this);
        node03.setOnClickListener(this);
        node04.setOnClickListener(this);
        node10.setOnClickListener(this);
        node11.setOnClickListener(this);
        node12.setOnClickListener(this);
        node13.setOnClickListener(this);
        node14.setOnClickListener(this);
        node20.setOnClickListener(this);
        node21.setOnClickListener(this);
        node22.setOnClickListener(this);
        node23.setOnClickListener(this);
        node24.setOnClickListener(this);
        node30.setOnClickListener(this);
        node31.setOnClickListener(this);
        node32.setOnClickListener(this);
        node33.setOnClickListener(this);
        node34.setOnClickListener(this);
        node40.setOnClickListener(this);
        node41.setOnClickListener(this);
        node42.setOnClickListener(this);
        node43.setOnClickListener(this);
        node44.setOnClickListener(this);
        node50.setOnClickListener(this);
        node51.setOnClickListener(this);
        node52.setOnClickListener(this);
        node53.setOnClickListener(this);
        node54.setOnClickListener(this);

        nodes = new int[]{2, 2, 1, 3, 2, 1};
        path = new int[11][2];
        i = 0;
        n = 6;
        t = 10;

        newgame();


        /*
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
*/
        /*
        newgraph_bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int k=newgraph(i);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    Toast.makeText(MainActivity.this,path[i][0],Toast.LENGTH_SHORT ).show();
                }
            }
        });
*/
    }

    private int newgraph(int i) {

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int r;
        int v = -1;
        if (i == n - 1) {
            for (int j = 0; j < nodes[i]; j++) {

                Random random = new Random();
                r = list.get(random.nextInt(list.size()));

                path[t - nodes[i] + 1 + j][0] = i;
                path[t - nodes[i] + 1 + j][1] = r;

                t--;
                if (j == 0) {
                    v = r;
                }
                list.remove(new Integer(r));


            }
            return v;
        }

        for (int j = 0; j < nodes[i]; j++) {
            if (j == 0) {
                r = newgraph(1 + i);
            } else {
                Random random = new Random();
                r = list.get(random.nextInt(list.size()));

            }

            path[t][0] = i;
            path[t][1] = r;

            t--;
            if (j == nodes[i] - 1) {
                v = r;
            }
            list.remove(new Integer(r));
        }


        return v;
    }

    @Override
    public void onClick(View view) {
        int node;
        switch (view.getId()) {
            case R.id.node00:
                if (x != 0 || y != 0) {
                    x = 0;
                    y = 0;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node00.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node00.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node00.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node01:
                if (x != 0 || y != 1) {
                    x = 0;
                    y = 1;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node01.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node01.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node01.setBackground(getResources().getDrawable(R.drawable.cancel));
                    }
                }
                break;
            case R.id.node02:
                if (x != 0 || y != 2) {
                    x = 0;
                    y = 2;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node02.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node02.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node02.setBackground(getResources().getDrawable(R.drawable.cancel));
                    }
                }
                break;
            case R.id.node03:
                if (x != 0 || y != 3) {
                    x = 0;
                    y = 3;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node03.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node03.setText(String.valueOf(node));

                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node03.setBackground(getResources().getDrawable(R.drawable.cancel));
                    }
                }
                break;
            case R.id.node04:
                if (x != 0 || y != 4) {
                    x = 0;
                    y = 4;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node04.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node04.setText(String.valueOf(node));

                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node04.setBackground(getResources().getDrawable(R.drawable.cancel));
                    }
                }
                break;
            case R.id.node10:
                if (x != 1 || y != 0) {
                    x = 1;
                    y = 0;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node10.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node10.setText(String.valueOf(node));

                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node10.setBackground(getResources().getDrawable(R.drawable.cancel));
                    }
                }
                break;
            case R.id.node11:
                if (x != 1 || y != 1) {
                    x = 1;
                    y = 1;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node11.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node11.setText(String.valueOf(node));

                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node11.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node12:
                if (x != 1 || y != 2) {
                    x = 1;
                    y = 2;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node12.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node12.setText(String.valueOf(node));

                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node12.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node13:
                if (x != 1 || y != 3) {
                    x = 1;
                    y = 3;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node13.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node13.setText(String.valueOf(node));

                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node13.setBackground(getResources().getDrawable(R.drawable.cancel));
                    }
                }
                break;
            case R.id.node14:
                if (x != 1 || y != 4) {
                    x = 1;
                    y = 4;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node14.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node14.setText(String.valueOf(node));

                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node14.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node20:
                if (x != 2 || y != 0) {
                    x = 2;
                    y = 0;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node20.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node20.setText(String.valueOf(node));

                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node20.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node21:
                if (x != 2 || y != 1) {
                    x = 2;
                    y = 1;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node21.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node21.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node21.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node22:
                if (x != 2 || y != 2) {
                    x = 2;
                    y = 2;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node22.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node22.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node22.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node23:
                if (x != 2 || y != 3) {
                    x = 2;
                    y = 3;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node23.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node23.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node23.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node24:
                if (x != 2 || y != 4) {
                    x = 2;
                    y = 4;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node24.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node24.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node24.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node30:
                if (x != 3 || y != 0) {
                    x = 3;
                    y = 0;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node30.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node30.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node30.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node31:
                if (x != 3 || y != 1) {
                    x = 3;
                    y = 1;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node31.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node31.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node31.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node32:
                if (x != 3 || y != 2) {
                    x = 3;
                    y = 2;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node32.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node32.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node32.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node33:
                if (x != 3 || y != 3) {
                    x = 3;
                    y = 3;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node33.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node33.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node33.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node34:
                if (x != 3 || y != 4) {
                    x = 3;
                    y = 4;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node34.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node34.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node34.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node40:
                if (x != 4 || y != 0) {
                    x = 4;
                    y = 0;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node40.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node40.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node40.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node41:
                if (x != 4 || y != 1) {
                    x = 4;
                    y = 1;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node41.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node41.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node41.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node42:
                if (x != 4 || y != 2) {
                    x = 4;
                    y = 2;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node42.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node42.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node42.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node43:
                if (x != 4 || y != 3) {
                    x = 4;
                    y = 3;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node43.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node43.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node43.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node44:
                if (x != 4 || y != 4) {
                    x = 4;
                    y = 4;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node44.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node44.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node44.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node50:
                if (x != 5 || y != 0) {
                    x = 5;
                    y = 0;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node50.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node50.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node50.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node51:
                if (x != 5 || y != 1) {
                    x = 5;
                    y = 1;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node51.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node51.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node51.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node52:
                if (x != 5 || y != 2) {
                    x = 5;
                    y = 2;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node52.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node52.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node52.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node53:
                if (x != 5 || y != 3) {
                    x = 5;
                    y = 3;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node53.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node53.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node53.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;
            case R.id.node54:
                if (x != 5 || y != 4) {
                    x = 5;
                    y = 4;
                    node = checkposibility(x, y);
                    if (node >= 0) {
                        node54.setBackground(getResources().getDrawable(R.drawable.greenball));
                        node54.setText(String.valueOf(node));
                        checkGamecomplete();

                    } else {
                        checkLevel(x, y);
                        node54.setBackground(getResources().getDrawable(R.drawable.cancel));

                    }
                }
                break;

            case R.id.newgraph_bt:
                newgame();
                // Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                break;
        }

    }

    public void newgame() {
        x = -1;
        y = -1;
        i = 0;
        t = 10;
        n = 6;
        path = new int[11][2];
        correctcount = 0;
        newgraph(i);
        level = new int[]{3, 3, 3, 3, 3, 3};
        gameover = false;
        gamereset();
        // Random random = new Random();
        //int r = list.get(random.nextInt(list.size()));

        String str;
        str = "Flow: ";
        for (int i = 0; i < 11; i++) {

            str = str + path[i][0] + " " + path[i][1] + " -> ";

        }
        display_graph.setText(str);
        Toast.makeText(this,"New Game",Toast.LENGTH_SHORT).show();
    }

    private void checkGamecomplete() {
        correctcount++;
        if (correctcount == 11) {

            //Toast.makeText(MainActivity.this, "CONGRATULATIONS! You WON", Toast.LENGTH_LONG).show();
            //display_graph.setText("Generate New graph");
            alertnextgame(1);
        }
    }

    private void checkLevel(int x, int y) {

        level[x]--;
        if (level[x] == 0) {
            gameover = true;
            //Toast.makeText(MainActivity.this, "Game Over! You Lost", Toast.LENGTH_LONG).show();
            //display_graph.setText("Generate New graph");
            alertnextgame(0);
        }
    }

    private int checkposibility(int x, int y) {
        int flag = 0;
        int node = -1;
        for (int i = 0; i < 11; i++) {
            if (x == path[i][0] && y == path[i][1]) {
                //markNode(x, y, "green");
                node = i;
                flag = 1;

            }
        }
        return node;

    }

    private void markNode(int x, int y, String color) {
        String id = "node" + x + y;

    }

    private void alertnextgame(int flag) {
        DialogFragment_newgame dialogFragment = new DialogFragment_newgame();
        dialogFragment.setResult(flag);
        dialogFragment.show(getSupportFragmentManager(), "dialog_fragment");


    }

    private void gamereset() {
        node00.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node00.setText("-");
        node01.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node01.setText("-");
        node02.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node02.setText("-");
        node03.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node03.setText("-");
        node04.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node04.setText("-");
        node10.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node10.setText("-");
        node11.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node11.setText("-");
        node12.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node12.setText("-");
        node13.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node13.setText("-");
        node14.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node14.setText("-");
        node20.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node20.setText("-");
        node21.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node21.setText("-");
        node22.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node22.setText("-");
        node23.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node23.setText("-");
        node24.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node24.setText("-");
        node30.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node30.setText("-");
        node31.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node31.setText("-");
        node32.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node32.setText("-");
        node33.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node33.setText("-");
        node34.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node34.setText("-");
        node40.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node40.setText("-");
        node41.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node41.setText("-");
        node42.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node42.setText("-");
        node43.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node43.setText("-");
        node44.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node44.setText("-");
        node50.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node50.setText("-");
        node51.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node51.setText("-");
        node52.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node52.setText("-");
        node53.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node53.setText("-");
        node54.setBackground(getResources().getDrawable(R.drawable.blackballoon));
        //node54.setText("-");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu_game, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rules:
                //Toast.makeText(OpenActivity.this, "Share selected", Toast.LENGTH_SHORT).show();
                DialogFragment_rules dialogFragment = new DialogFragment_rules();
                dialogFragment.show(getSupportFragmentManager(), "dialog_fragment");
                break;
            case R.id.newgame:
                newgame();
                break;
        }
        return true;
    }

}
