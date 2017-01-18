package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.neemshade.gitsample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {



    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);

        final TextView receiveTxt = (TextView) view.findViewById(R.id.text_receive);
        final Button receiveBtn = (Button) view.findViewById(R.id.button_receive);

        receiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = getArguments().get("value").toString();
                receiveTxt.setText(str);
            }
        });

        return view;


    }

}
