val mReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {

            when (intent?.action) {
                BluetoothAdapter.ACTION_STATE_CHANGED -> {
                    val state = intent.getIntExtra(
                        BluetoothAdapter.EXTRA_STATE,
                        BluetoothAdapter.ERROR
                    );
                    when (state) {
                        BluetoothAdapter.STATE_OFF -> {
                                Timber.d("BluetoothAdapter.STATE_OFF ")
                        }
                        BluetoothAdapter.STATE_TURNING_OFF -> {
                            Timber.d("BluetoothAdapter.STATE_TURNING_OFF ")
                        }
                        BluetoothAdapter.STATE_ON -> {
                            beaconInitialize()
                            Timber.d("BluetoothAdapter.STATE_ON ")
                        }
                        BluetoothAdapter.STATE_TURNING_ON -> {
                            Timber.d("BluetoothAdapter.STATE_TURNING_ON ")
                        }

                    }

                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        
        val filter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(mReceiver, filter);
    }

   override fun onDestroy() {
        super.onDestroy()
       
        unregisterReceiver(mReceiver)
    }
